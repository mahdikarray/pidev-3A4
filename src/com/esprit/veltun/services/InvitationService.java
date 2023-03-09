package com.esprit.veltun.services;

import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.services.base.BaseService;

public interface InvitationService extends BaseService<Invitation> {
    void checkExpiredInvitation();
}
