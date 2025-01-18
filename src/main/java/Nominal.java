public enum Nominal {
    R5000(5000),
    R100(100),
    R1000(1000),
    R2000(2000),
    R500(500),
    R50(50);
    final Integer nominal;
    Nominal(Integer nominal){
        this.nominal = nominal;
    }
}
