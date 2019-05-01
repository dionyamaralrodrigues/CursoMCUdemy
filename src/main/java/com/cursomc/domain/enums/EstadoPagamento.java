package com.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(0, "Pagamento em aberto"),
	QUITADO(90, "Pagamento concluído"),
	CANCELADO(80, "Pagamento cancelado");
	
	private int codigo;
	private String descricao;
	
	private EstadoPagamento(int cod, String desc){
		this.codigo = cod;
		this.descricao = desc;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido: " + cod);
		
	}
}
