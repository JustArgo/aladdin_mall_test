package com.mi360.aladdin.mall.domain;

import java.io.Serializable;

public class ServiceTest implements Serializable {
    private Integer ID;

    private String methodName;

    private String serviceName;

    private String serviceCode;

    private String methodUrl;

    private String paramData;

    private static final long serialVersionUID = 1L;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode == null ? null : serviceCode.trim();
    }

    public String getMethodUrl() {
        return methodUrl;
    }

    public void setMethodUrl(String methodUrl) {
        this.methodUrl = methodUrl == null ? null : methodUrl.trim();
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData == null ? null : paramData.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", methodName=").append(methodName);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", serviceCode=").append(serviceCode);
        sb.append(", methodUrl=").append(methodUrl);
        sb.append(", paramData=").append(paramData);
        sb.append("]");
        return sb.toString();
    }
}