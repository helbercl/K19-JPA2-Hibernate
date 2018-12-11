package br.com.k19.bases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.livrariak19.entitymodelo.Editora;

public class CriarEntidadesBanco {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        EntityManagerFactory factory =  
                Persistence.createEntityManagerFactory("K21_livraria_pu");
        
        
        //Manipular entidades - obtido atraves da EntityManagerFactory
        EntityManager manager = factory.createEntityManager();

        Editora editora =new Editora();
        editora.setNome("Pearson");
        editora.setEmail("pearson@pearson.com");
        
        //persistir dados INSERÇÂO
        manager.persist(editora);
        
        
        /*Buscando Dados -  find e getReference do EntityManager
         * find - recupera os dados desejados imediatamente
         * getRefence -posterga ate uma primeira chamada no metodo get do objeto desejado
         * */
       // Editora recuperarEditora1 = manager.find(Editora.class, 1L);
       // Editora recuperarEditora2 = manager.getReference(Editora.class, 2L);        
        
        /*Removendo Dados
         * remove- remove um registro referente ao objeto
         * */
       //Editora editoraRemove = manager.find(Editora.class, 1L);
       // manager.remove(editoraRemove);
        
        /* Atualizando Dados
         * utiliza o proprio set do objeto 
         * */
       // Editora editoraUpdate = manager.find(Editora.class, 1L);
       // editoraUpdate.setNome("Modificado");
        
        /* Listando Dados
         * utiliza a linguaguem de consulta JPA que é a JPQL. 
         * A sintaxe é a mesma para bancos distintos. 
         * */
        //Query query = manager.createQuery("Select e from editora e");
       // List<Editora> listaEditoras = query.getResultList();
        
        factory.close();
    }

}
