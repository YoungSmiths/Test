package cn.young.test;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-11-3 下午1:11
 */

/**
 * 连接邮件服务器的会话信息
 * 默认为163邮箱
 */
class EmailConfiguration {

    /**
     * 邮件发送协议
     */
    private String PROTOCOL = "smtp";

    /**
     * SMTP邮件服务器
     */
    private String HOST = "smtp.163.com";

    /**
     * SMTP邮件服务器默认端口
     */
    private String PORT = "25";

    /**
     * 是否要求身份认证
     */
    private String IS_AUTH = "true";

    /**
     * 是否启用调试模式（启用调试模式可打印客户端与服务器交互过程时一问一答的响应消息）
     */
    private String IS_ENABLED_DEBUG_MOD = "true";

    public EmailConfiguration(String PROTOCOL, String HOST, String PORT, String IS_AUTH, String IS_ENABLED_DEBUG_MOD) {
        this.PROTOCOL = PROTOCOL;
        this.HOST = HOST;
        this.PORT = PORT;
        this.IS_AUTH = IS_AUTH;
        this.IS_ENABLED_DEBUG_MOD = IS_ENABLED_DEBUG_MOD;
    }

    public EmailConfiguration() {
    }

    public String getPROTOCOL() {
        return PROTOCOL;
    }

    public EmailConfiguration setPROTOCOL(String PROTOCOL) {
        this.PROTOCOL = PROTOCOL;
        return this;
    }

    public String getHOST() {
        return HOST;
    }

    public EmailConfiguration setHOST(String HOST) {
        this.HOST = HOST;
        return this;
    }

    public String getPORT() {
        return PORT;
    }

    public EmailConfiguration setPORT(String PORT) {
        this.PORT = PORT;
        return this;
    }

    public String getIS_AUTH() {
        return IS_AUTH;
    }

    public EmailConfiguration setIS_AUTH(String IS_AUTH) {
        this.IS_AUTH = IS_AUTH;
        return this;
    }

    public String getIS_ENABLED_DEBUG_MOD() {
        return IS_ENABLED_DEBUG_MOD;
    }

    public EmailConfiguration setIS_ENABLED_DEBUG_MOD(String IS_ENABLED_DEBUG_MOD) {
        this.IS_ENABLED_DEBUG_MOD = IS_ENABLED_DEBUG_MOD;
        return this;
    }
}

