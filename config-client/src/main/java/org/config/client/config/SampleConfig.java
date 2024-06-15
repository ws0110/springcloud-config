package org.config.client.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Setter
@Getter
@ConfigurationProperties("app1.sample")
@RefreshScope  // 설정 정보 변경 시 리로딩(/actuator/refresh 호출)
@ToString
public class SampleConfig {
    private String message;
}
