package org.jenkinsci.plugins.buildwithparameters;

import hudson.model.BooleanParameterValue;
import hudson.model.ParameterValue;
import hudson.model.PasswordParameterValue;
import hudson.model.StringParameterValue;
import hudson.util.Secret;

public class BuildParameter {
    private String name, description, value;
    private boolean isPasswordParam;

    public BuildParameter(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(ParameterValue parameterValue) {
        if (parameterValue instanceof StringParameterValue) {
            this.value = ((StringParameterValue) parameterValue).value;
        } else if (parameterValue instanceof BooleanParameterValue) {
            this.value = String.valueOf(((BooleanParameterValue) parameterValue).value);
        } else if (parameterValue instanceof PasswordParameterValue) {
            Secret secret = ((PasswordParameterValue) parameterValue).getValue();
			this.value = Secret.toString(secret);
        }
    }

    public void setPasswordParam(boolean isPasswordParam) {
		this.isPasswordParam = isPasswordParam;
	}
    
    public boolean isPasswordParam() {
		return isPasswordParam;
	}
    
}
