
@Entity
public class Domaine {

	@Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_domaine;
	
	private String name;
	
	public static Model.Find<Long, Domaine> find = new Model.Find<Long, Domaine>() {};
	
	public static List<Domaine> getAllDomaine(S){
        return findList();
    }
	
	public Long getId_domaine() {
        return id_user;
    }

    public void setId_domaine(Long id_domaine) {
        this.id_domaine = id_domaine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.login = name;
    }
}
