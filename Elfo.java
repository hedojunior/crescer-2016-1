public class Elfo {
	private String nome;
	private int experiencia, flechas = 42;

	public void atirarFlechas() {
		this.experiencia++;
	}

	public Elfo(String nome) {
		this.nome = nome;
	}

	public void atirarFlechaRefactory() {
		boolean acertar = true;
		if (acertar) {
			experiencia++;
		}
		flechas--;
	}

	public void atirarFlechaDwarf(Dwarf dwarf) {
		flechas--;
		dwarf.danoRecebido();

	}

}
