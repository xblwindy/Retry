package com.wx.retry.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 */
@Entity
@Table(name = "retry_config")
@Data
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
