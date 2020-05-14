
class Start{
    static void main(String[] args){

        def new_dir = new File('conf')
        new_dir.mkdir()

        def fp_name = args[0];

        //build_fp_name_conf(arg_fp_name);

        def pw = new File("${fp_name}.conf")

            pw.write("""
# ЕФС ФП Аутентификация и маршрутизация
${fp_name}.cluster=${fp_name}

${fp_name}.object.jdbcProvider_Oracle=on
${fp_name}.object.ds_UFEDB=on
${fp_name}.object.ds_logDataSource=on
${fp_name}.object.wmqcf_Audit=on
${fp_name}.object.mqQueue_AuditSendQueue=on
${fp_name}.object.wmqcf_Logger=on
${fp_name}.object.mqQueue_LoggerSendQueue=on

${fp_name}.object.snsb_baseUrl=on
${fp_name}.object.snsb_springProfile=on

# jdbc/UFEDB
jdbc.UFEDB.url=\${jdbc.efs.url}
jdbc.UFEDB.alias=UFS
jdbc.UFEDB.user=UFS
jdbc.UFEDB.password=UFS
jdbc.UFEDB.newconn=\${jdbc.newconn}
jdbc.UFEDB.newconnRetryCount=\${jdbc.newconnRetryCount}
jdbc.UFEDB.newconnRetryInterval=\${jdbc.newconnRetryInterval}
jdbc.UFEDB.loginTimeout=\${jdbc.loginTimeout}
jdbc.UFEDB.maxconn=\${jdbc.maxconn}
jdbc.UFEDB.minconn=\${jdbc.minconn}
jdbc.UFEDB.testconnInterval=\${jdbc.testconnInterval}
jdbc.UFEDB.testconn=\${jdbc.testconn}
jdbc.UFEDB.connTimeout=\${jdbc.connectionTimeout}
jdbc.UFEDB.purgePolicy=\${jdbc.purgePolicy}
jdbc.UFEDB.surgeThreshold=\${jdbc.surgeThreshold}
jdbc.UFEDB.surgeCreationInterval=\${jdbc.surgeCreationInterval}

# jdbc/UFSLG
jdbc.logDataSource.url=\${jdbc.log.url}
jdbc.logDataSource.alias=LOG_DB
jdbc.logDataSource.user=LOG_DB
jdbc.logDataSource.password=LOG_DB
jdbc.logDataSource.newconn=\${jdbc.newconn}
jdbc.logDataSource.newconnRetryCount=\${jdbc.newconnRetryCount}
jdbc.logDataSource.newconnRetryInterval=\${jdbc.newconnRetryInterval}
jdbc.logDataSource.loginTimeout=\${jdbc.loginTimeout}
jdbc.logDataSource.maxconn=\${jdbc.maxconn}
jdbc.logDataSource.minconn=\${jdbc.minconn}
jdbc.logDataSource.testconnInterval=\${jdbc.testconnInterval}
jdbc.logDataSource.testconn=\${jdbc.testconn}
jdbc.logDataSource.connTimeout=\${jdbc.connectionTimeout}
jdbc.logDataSource.purgePolicy=\${jdbc.purgePolicy}
jdbc.logDataSource.surgeThreshold=\${jdbc.surgeThreshold}
jdbc.logDataSource.surgeCreationInterval=\${jdbc.surgeCreationInterval}

# jms/logger/connectionFactory/loggerCF
${fp_name}.wmqcf.loggerCF.qmgrName=qmgrName
${fp_name}.wmqcf.loggerCF.qmgrHostname=qmgrHostname
${fp_name}.wmqcf.loggerCF.qmgrPortNumber=1414
${fp_name}.wmqcf.loggerCF.qmgrSvrconnChannel=qmgrSvrconnChannel
# SSL
#true|false
${fp_name}.wmqcf.loggerCF.ssl.enabled=false
${fp_name}.wmqcf.loggerCF.ssl.config=SSLConf

# jms/logger/queue/logIn
${fp_name}.queue.logIn.baseQueueName=logQueue
${fp_name}.queue.logIn.persistence=NON

# jms/audit/connectionFactory/auditCF
${fp_name}.wmqcf.auditCF.qmgrName=qmgrName
${fp_name}.wmqcf.auditCF.qmgrHostname=qmgrHostname
${fp_name}.wmqcf.auditCF.qmgrPortNumber=1414
${fp_name}.wmqcf.auditCF.qmgrSvrconnChannel=qmgrSvrconnChannel
# SSL
#true|false
${fp_name}.wmqcf.auditCF.ssl.enabled=false
${fp_name}.wmqcf.auditCF.ssl.config=SSLConf

# jms/audit/queue/auditIn
${fp_name}.queue.auditIn.baseQueueName=auditQueue
${fp_name}.queue.auditIn.persistence=NON

# Name space bindings
# Значение для baseUrl (указать верное значение url rest сервиса СУП)
${fp_name}.snsb.baseUrl.stringToBind=<url>
# Значение для springProfile (указать LOCAL или PROM)
${fp_name}.snsb.springProfile.stringToBind=PROM

            ""","utf-8")
    }
}