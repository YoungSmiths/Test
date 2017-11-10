package cn.young.test;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-11-3 下午1:09
 */

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 向邮件服务器提交认证信息
 */
public class EmailUser extends Authenticator {

    /**
     * 发件人设置昵称
     */
    private String nick;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 定义发送者
     *
     * @param nick     昵称（可选）
     * @param email    邮箱地址
     * @param password 密码
     */
    public EmailUser(String nick, String email, String password) {
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    /**
     * 定义接受者
     *
     * @param nick
     * @param email
     */
    public EmailUser(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication(email, password);
    }

    public String getNick() {
        return nick;
    }

    public EmailUser setNick(String nick) {
        this.nick = nick;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmailUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EmailUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
