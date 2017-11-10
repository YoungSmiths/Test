package cn.young.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-11-3 下午1:18
 */
public class Email {

    /**
     * 初始化连接邮件服务器的会话信息
     */
    private Properties props = new Properties();

    private EmailConfiguration emailConfiguration;

    /**
     * 主题
     */
    private String theme;

    /**
     * 发送时间
     */
    private Date time;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 发送者
     */
    private EmailUser sender;

    /**
     * 接受者
     */
    private List<EmailUser> receivers = new ArrayList<>();

    /**
     * 抄送
     */
    private List<EmailUser> recipient = new ArrayList<>();

    /**
     * 密送
     */
    private List<EmailUser> secretSend = new ArrayList<>();

    /**
     * 默认回复人
     */
    private String replyTo;

    /**
     * 头  head 设置优先级 1：紧急。3：普通。5：低
     * 要求阅读回执
     */
    private List<String> head = new ArrayList<>();

    /**
     * 附件
     */
    private List<Object> attaches = new ArrayList<>();

    public Email(EmailConfiguration emailConfiguration,
                 String theme,
                 Date time,
                 String content,
                 EmailUser sender,
                 List<EmailUser> receivers,
                 List<EmailUser> recipient,
                 List<EmailUser> secretSend,
                 String replyTo,
                 List<String> head,
                 List<Object> attaches) {
        initProperties(emailConfiguration);
        this.theme = theme;
        this.time = time;
        this.content = content;
        this.sender = sender;
        this.receivers = receivers;
        this.recipient = recipient;
        this.secretSend = secretSend;
        this.replyTo = replyTo;
        this.head = head;
        this.attaches = attaches;
    }

    public Email(String theme, String content, EmailUser sender, List<EmailUser> receivers) {
        this(null, theme, new Date(), content, sender, receivers, null, null, null, null, null);
    }

    private void initProperties(EmailConfiguration emailConfiguration) {
        if (emailConfiguration == null)
            emailConfiguration = new EmailConfiguration();
        props.setProperty("mail.transport.protocol", emailConfiguration.getPROTOCOL());
        props.setProperty("mail.smtp.host", emailConfiguration.getHOST());
        props.setProperty("mail.smtp.port", emailConfiguration.getPORT());
        props.setProperty("mail.smtp.auth", emailConfiguration.getIS_AUTH());
        props.setProperty("mail.debug", emailConfiguration.getIS_ENABLED_DEBUG_MOD());
    }

    public Properties getProps() {
        return props;
    }

    public Email setProps(Properties props) {
        this.props = props;
        return this;
    }

    public EmailConfiguration getEmailConfiguration() {
        return emailConfiguration;
    }

    public Email setEmailConfiguration(EmailConfiguration emailConfiguration) {
        this.emailConfiguration = emailConfiguration;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public Email setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public Email setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Email setContent(String content) {
        this.content = content;
        return this;
    }

    public EmailUser getSender() {
        return sender;
    }

    public Email setSender(EmailUser sender) {
        this.sender = sender;
        return this;
    }

    public List<EmailUser> getReceivers() {
        return receivers;
    }

    public Email setReceivers(List<EmailUser> receivers) {
        this.receivers = receivers;
        return this;
    }

    public List<EmailUser> getRecipient() {
        return recipient;
    }

    public Email setRecipient(List<EmailUser> recipient) {
        this.recipient = recipient;
        return this;
    }

    public List<EmailUser> getSecretSend() {
        return secretSend;
    }

    public Email setSecretSend(List<EmailUser> secretSend) {
        this.secretSend = secretSend;
        return this;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public Email setReplyTo(String replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public List<String> getHead() {
        return head;
    }

    public Email setHead(List<String> head) {
        this.head = head;
        return this;
    }

    public List<Object> getAttaches() {
        return attaches;
    }

    public Email setAttaches(List<Object> attaches) {
        this.attaches = attaches;
        return this;
    }

}
