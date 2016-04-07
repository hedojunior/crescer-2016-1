public class CestoDeLembas {

    private int lembas;

    public CestoDeLembas(int lembas) {
        this.lembas = lembas;
    }

    public boolean podeDividirEmPares() {
        return lembas > 2 && lembas <= 100 && lembas % 2 == 0;
        //terneiro
        // return podeDividir ? true: false;
    }

}