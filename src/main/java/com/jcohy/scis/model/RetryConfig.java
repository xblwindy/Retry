package com.jcohy.scis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 */
@Entity
@Table(name = "retry_config")
public class RetryConfig implements Serializable {

    private static final long serialVersionUID = 7L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "args")
    private String args;
    @Column(name = "successful")
    private String successful;
    @Column(name = "callback_url")
    private String callbackUrl;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getSuccessful() {
        return successful;
    }

    public void setSuccessful(String successful) {
        this.successful = successful;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RetryConfig{");
        sb.append("id=").append(id);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", args='").append(args).append('\'');
        sb.append(", successful='").append(successful).append('\'');
        sb.append(", callbackUrl='").append(callbackUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
