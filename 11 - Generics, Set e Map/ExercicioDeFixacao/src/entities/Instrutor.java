package entities;

import java.util.HashSet;
import java.util.Set;

public class Instrutor {

    private Integer id;
    private String nome;

    Set<Curso> cursos = new HashSet<>();

    public Instrutor(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<User> consultSet(Set<User> listUser1, Set<User> listUser2, Set<User> listUser3){
        listUser1.addAll(listUser2);
        listUser1.addAll(listUser3);
        return listUser1;
    }
}
