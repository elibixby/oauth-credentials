package com.google.jenkins.plugins.credentials.oauth.thirdparty;

import com.cloudbees.plugins.credentials.domains.DomainRequirement;
import com.cloudbees.plugins.credentials.domains.DomainSpecification;

import hudson.Extension;

@Extension
public class OAuth3LOProviderSpecification extends DomainSpecification {

  private final String providerName;
  private final String authzEndpoint;
  private final String tokenEndpoint;
  
  
  public OAuth3LOProviderSpecification(String providerName, String authzEndpoint, String tokenEndpoint) {
    this.providerName = providerName;
    this.authzEndpoint = authzEndpoint;
    this.tokenEndpoint = tokenEndpoint;
  }

  /* (non-Javadoc)
   * @see com.cloudbees.plugins.credentials.domains.DomainSpecification#test(com.cloudbees.plugins.credentials.domains.DomainRequirement)
   */
  @Override
  public Result test(DomainRequirement arg0) {
    if(arg0 instanceof OAuth3LOProviderRequirement){
      return (((OAuth3LOProviderRequirement)arg0).getAuthzEndpoint().equals(this.authzEndpoint) &&
          ((OAuth3LOProviderRequirement)arg0).getTokenEndpoint().equals(this.tokenEndpoint)) 
          ? Result.POSITIVE : Result.NEGATIVE;          
    } else {
      return Result.UNKNOWN;
    }
  }
  
  public String getProviderName(){
    return this.providerName;
  }

}
