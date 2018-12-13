package br.com.k19.bases;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.livrariak19.entitymodelo.Autor;
import br.com.livrariak19.entitymodelo.Editora;

public class CriarEntidadesBanco {

    public static void main(String[] args) {

        // indica o name do persistence unit que foi informado no arquivo de
        // configuração do hibernate - persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_livraria_pu");

        // Gerenciamento de Entidade obtido do gerenciamento de Fabrica de entidade
        EntityManager manager = factory.createEntityManager();

        // Persistir ou Inserir Objeto

        
          Editora editora = new Editora(); 
          Scanner entrada = new Scanner(System.in);
          System.out.println("Digite o Nome da Editora");
          editora.setName(entrada.nextLine());
          System.out.println("Digite o Email da Editora");
          editora.setEmail(entrada.nextLine()); 
          
         
          
          Autor autor = new Autor();
          System.out.println("Digite o nome do Autor");
          autor.setName(entrada.nextLine());
          
          entrada.close();
          manager.persist(editora); 
          manager.persist(autor);
          manager.getTransaction().begin();
          manager.getTransaction().commit();
         

        /*
         * Listar Objetos
         * 
         */
        System.out.println("======================Lista Editoras========================");
        Query queryEditor = manager.createQuery("Select e from Editora e");
        List<Editora> listaEditoras = queryEditor.getResultList();
        for (Editora editoraList : listaEditoras) {
            System.out.println("Editora :" + editoraList.getName() + " com email :" + editoraList.getEmail());
        }
        System.out.println("======================Lista Editoras========================");
        System.out.println();
        System.out.println("======================Lista Autores========================");
        Query queryAutor = manager.createQuery("Select a from Autor a");
        List<Autor> listaAutor = queryAutor.getResultList();
        if (listaAutor.size() == 0) {
            System.out.println("Não há registro de Autores");
        } else {
            for (Autor autorList : listaAutor) {

                System.out.println("Autor com nome " + autorList.getName());
            }
        }
        System.out.println("======================Lista Autores========================");
        factory.close();
    }

}
