package com.xiaoyou.service;

import com.xiaoyou.domain.user.EngineerDomain;

import java.util.List;

public interface IEngineer {
    //����ʦ����
    int engineerRequest(EngineerDomain engineer_domain);
    //����ʦ��֤
    List<EngineerDomain> engineerCertified( String user_name);
}