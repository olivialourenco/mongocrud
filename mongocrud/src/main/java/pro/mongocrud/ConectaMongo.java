
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro.mongocrud;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class ConectaMongo {

    public void insereValores (int id, String nome, String profissao, boolean trabalha){
        System.out.println("insereValores");
        // classe de conexão com o momgo
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("pessoa");
        MongoCollection<Document> docs = db.getCollection("pess");
        Entrada user = criaUsuario(id, nome, profissao, trabalha);
//cria um user obj da classe conectar, chamando o método
// createUser()        
        Document doc = criaDocumento(user);
//cria um doc que referencia o conteudo de user do createdocument()        
//obs, o banco so entende objetos do tipo document,        
        docs.insertOne(doc);//insere no mongo  conteudo de doc
        mostraValores();
        System.out.println("insereValores ok");
    }
    public Entrada criaUsuario (int id, String nome, String profissao, boolean trabalha){
//esse metodo deve ser uma entrada externa
//interface scanner ou JoptionPanel
        Entrada u = new Entrada();
        u.setId(id);
        u.setNome(nome);
        u.setProfissao(profissao);
        u.setTrabalha(trabalha);
        return u;
    }
    public Document criaDocumento(Entrada user){
        Document FazedoDeDoc = new Document();
        FazedoDeDoc.append("_id", user.getId());
        FazedoDeDoc.append("nome", user.getNome());
        FazedoDeDoc.append("profissao", user.getProfissao());
        FazedoDeDoc.append("trabalha", user.getTrabalha());
        return FazedoDeDoc;
    }
    public void mostraValores(){
        System.out.println("mostraValores");
        MongoClient mongo = new MongoClient ("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("pessoa");
        MongoCollection<Document> docs = db.getCollection("pess");
        for (Document doc : docs.find()){
            System.out.println("item: " +doc);
        }
        System.out.println("mostraValores OK");
    }
    public void updateValores (String nome, String profissao){
        System.out.println("updateValores");
        
        MongoClient mongo = new MongoClient ("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("pessoa");
        MongoCollection<Document> docs = db.getCollection("pess");
        
        docs.updateOne (Filters.eq("nome", nome),
                Updates.set("profissao", profissao));
        System.out.println("documento teve sucesso no update...");
        for (Document doc : docs.find()){
            System.out.println("item update: " +doc);
        }
    }
    public void deleteValores (String nome){
        System.out.println("deleteValores");
        
        MongoClient mongo = new MongoClient ("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("pessoa");
        MongoCollection<Document> docs = db.getCollection("pess");
        
        docs.deleteOne (Filters.eq("nome", nome));
        System.out.println("documento teve sucesso no delete...");
        }    
}
