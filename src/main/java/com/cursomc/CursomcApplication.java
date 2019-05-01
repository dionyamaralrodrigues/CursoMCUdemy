package com.cursomc;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Cidade;
import com.cursomc.domain.Cliente;
import com.cursomc.domain.Endereco;
import com.cursomc.domain.Estado;
import com.cursomc.domain.Produto;
import com.cursomc.domain.enums.TipoCliente;
import com.cursomc.repository.CategoriaRepository;
import com.cursomc.repository.CidadeRepository;
import com.cursomc.repository.ClienteRepository;
import com.cursomc.repository.EnderecoRepository;
import com.cursomc.repository.EstadoRepository;
import com.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository; 
		
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository; 
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 20.00);
		
		cat1.setProdutos(Arrays.asList(p1, p2, p3));
		cat2.setProdutos(Arrays.asList(p2));
		
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1, cat2));
		p3.setCategorias(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", e1);
		Cidade c2 = new Cidade(null, "São Paulo", e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);
		
		e1.setCidades(Arrays.asList(c1));
		e2.setCidades(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "maria", "maria@maria.com", "123456789-60", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("16-11151124","16-987714141"));
		Endereco end1 = new Endereco(null, "Rua tal", "1000", "Apto 1", "bairro Novo", "14141-888", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua fulano", "2500", "Apto 10", "bairro velho", "11111-000", cli1, c2);
		cli1.setEnderecos(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		
		
	}
	
}
