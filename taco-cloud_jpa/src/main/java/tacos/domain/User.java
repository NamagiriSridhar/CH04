package tacos.domain;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;
@Entity
@Data
@NoArgsConstructor
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private  Long id;
	  private   String username;
	  private  String password;
	  private  String fullname;
	  private  String street;
	  private  String city;
	  private  String state;
	  private  String zip;
	  private  String phoneNumber;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}



	public User(String username, String password, String fullname, String street, String city, String state,
			String zip, String phoneNumber) {
		this.username=username;
		this.password=password;
		this.fullname=fullname;
		this.street=street;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNumber=phoneNumber;
	}

	
	

}
