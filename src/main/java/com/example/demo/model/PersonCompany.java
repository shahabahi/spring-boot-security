package com.example.demo.model;

public enum PersonCompany {

    EKI(1),
    SAIPA(3),
    MVM(2),
    IRAN(4),
    KERMAN(5),
    BAHMAN(6);

    private final int value;

    PersonCompany(int value) {
        this.value = value;
    }

    public static PersonCompany fromValue(Integer i) {

        if (i == null){
            return EKI;
        }

        switch (i) {
            case 1:
                return EKI;
            case 3:
                return SAIPA;
            case 2:
                return MVM;
            case 4:
                return IRAN;
            case 5:
                return KERMAN;
            case 6:
                return BAHMAN;
            default:
                return EKI;
        }
    }

    public Integer toValue() {
        return value;
    }

    public static PersonCompany fromType(String type) {
        if (type.equals(EKI.name())) {
            return EKI;
        } else if (type.equals(SAIPA.name())) {
            return SAIPA;
        } else if (type.equals(MVM.name())) {
            return MVM;
        } else if (type.equals(IRAN.name())) {
            return IRAN;
        } else if (type.equals(KERMAN.name())) {
            return KERMAN;
        }else if (type.equals(BAHMAN.name())) {
            return BAHMAN;
        } else {
            return EKI;
        }
    }
}
