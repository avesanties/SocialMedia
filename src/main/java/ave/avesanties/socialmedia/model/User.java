package ave.avesanties.socialmedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

//TODO: provide better id generation policy
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "name", nullable = false)
  private String name;

  @NotNull
  @Column(name = "email", nullable = false, length = 50)
  private String email;
  //TODO: make password stored as hash
  @NotNull
  @Column(name = "password", nullable = false)
  private String password;

  @OneToMany(mappedBy = "user_id")
  private Set<Post> posts = new HashSet<>();

  public User() {

  }
  public User(@NotNull String name, @NotNull String email, @NotNull String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public Set<Post> getPosts() {
    return Collections.unmodifiableSet(posts);
  }

  public void addPost(@NotNull Post post){
    posts.add(post);
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
