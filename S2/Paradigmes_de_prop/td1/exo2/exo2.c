// 1)  (Nlv + Nf + Nm + Np) / 4 > 10

// 2) Nm > (Nlv + Nf + Nm + Np) / 4 && Nf > (Nlv + Nf + Nm + Np) / 4

// 3) Nlv || Nf || Nm || Np > 10

// 4) Nlv > 10 && Nf > 10 && Nm > 10 && Np > 10

// 5) ((Nlv + Nf) / 2 >= 10 && (Nm + Np) / 2 < 10) || ((Nlv + Nf) / 2 < 10 && (Nm + Np) / 2 >= 10)

// 6) (Nlv + Nf + Nm + Np) / 4 >= 10 && (((Nlv + Nf) / 2 >= 10 && (Nm + Np) / 2 < 10) || ((Nlv + Nf) / 2 < 10 && (Nm + Np) / 2 >= 10))