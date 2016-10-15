package com.nikitakozlov.pury.profile;

public class StageId {
    private final ProfilerId profilerId;
    private final String stageName;
    private final int stageOrder;

    public StageId(ProfilerId profilerId, String stageName) {
        this(profilerId, stageName, 0);
    }

    public StageId(ProfilerId profilerId, String stageName, int stageOrder) {
        this.profilerId = profilerId;
        this.stageName = stageName;
        this.stageOrder = stageOrder;
    }

    public ProfilerId getProfilerId() {
        return profilerId;
    }

    public String getStageName() {
        return stageName;
    }

    public int getStageOrder() {
        return stageOrder;
    }
}
