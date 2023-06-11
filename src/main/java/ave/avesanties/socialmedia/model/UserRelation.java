package ave.avesanties.socialmedia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "userRelations")
@org.hibernate.annotations.Immutable
public class UserRelation {
  @Embeddable
  public static class Id implements Serializable {
    @Column(name = "follower_id")
    private Long followerId;
    @Column(name = "following_id")
    private Long followingId;

    public Id(){

    }
    public Id(Long followerId, Long followingId){
      this.followerId = followerId;
      this.followingId = followingId;
    }
  }

  @EmbeddedId
  private Id id = new Id();

  @ManyToOne
  @JoinColumn(name = "follower_id", insertable = false, updatable = false)
  private User follower;

  @ManyToOne
  @JoinColumn(name = "following_id", insertable = false, updatable = false)
  private User following;

  public UserRelation(){

  }

  public UserRelation(User follower, User following){
    this.id.followerId = follower.getId();
    this.id.followingId = following.getId();
  }
}
