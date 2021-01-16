package org.atech.portal.executor;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.*;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
public class SshCMD {


    static int executeLocalCmd(String shPath) {
        try {
            Process ps = Runtime.getRuntime().exec(shPath);
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    static String executeRemoteCmd(String userName, String password, String ipAddr, String cmd) {
        int TIME_OUT = 1000 * 5 * 60;
        String result = "";
        Connection conn  = null;
        Session session = null ;
        int ret =-1;
        try {
            //返回的结果
            if (InetAddress.getByName(ipAddr).isReachable(1500)) {
                conn = new Connection(ipAddr);
                conn.connect();
                boolean isAuthed = conn.authenticateWithPassword(userName, password);
                if (isAuthed) {
                    //打开一个会话
                    session = conn.openSession();
                    session.execCommand(cmd);
                    session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                    result = processStdout(session.getStdout(), cmd);
                    ret = session.getExitStatus();
                } else {
                    result = ("执行" + cmd + "命令时失败,连接目标主机失败,用户名密码错误");
                }
            } else {
                result = ("执行" + cmd + "命令时失败,连接目标主机失败,网络不通");
            }
        } catch (IOException e) {
            result = ("执行" + cmd + "命令时失败,未知原因");
        } finally {
            if (session != null) {
                session.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result + (ret==-1? "腳本異常退出":"腳本成功退出");
    }

    public static String processStdout(InputStream in, String cmd) {
        InputStream stdout = new BufferedInputStream(in);
        StringBuilder buffer = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout, StandardCharsets.UTF_8));
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line).append("\n");
            }
        } catch (IOException e) {
            buffer.append("执行" + cmd + "命令时失败,未知原因");
        }
        return buffer.toString();
    }


}

