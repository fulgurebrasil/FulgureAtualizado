package sh.surge.fulgure.fulgure_brasil.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import sh.surge.fulgure.fulgure_brasil.security.jwt.AuthenticationJwtFilter;
import sh.surge.fulgure.fulgure_brasil.security.jwt.JwtLoginFilter;
import sh.surge.fulgure.fulgure_brasil.security.jwt.JwtUtils;
import sh.surge.fulgure.fulgure_brasil.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
	private AuthenticationJwtFilter authenticationJwtFilter;
    // @Autowired
	// private AuthenticationJwtFailsEntryPoint unauthorizedHandler;
    // @Autowired
    // JwtLoginFilter jwtLoginFilter;
    
    // Retorna o objeto que gerencia a autenticação
    @Bean
    public AuthenticationManager authenticationManager(
        AuthenticationConfiguration authenticationConfiguration
    ) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    // @Bean
    // public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    //     AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
    //     authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    //     return authenticationManagerBuilder.build();
    // }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
    
        return authProvider;
    }

    // // Provedor Data Access Object (DAO)
    // // Recebe um Serviço de Usuário e interage com ele.
    // @Bean
    // public DaoAuthenticationProvider authenticationProvider() {
    //     DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
         
    //     authProvider.setUserDetailsService(userDetailsService);
    //     authProvider.setPasswordEncoder(passwordEncoder());
     
    //     return authProvider;
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }    

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService() {
    //     UserDetails user1 = User.withUsername("user1")
    //             .password(passwordEncoder().encode("user1Pass"))
    //             .roles("USER")
    //             .build();
    //     System.out.println(user1.getPassword());
    //     UserDetails user2 = User.withUsername("user2")
    //             .password(passwordEncoder().encode("user2Pass"))
    //             .roles("USER")
    //             .build();
    //     System.out.println(user2.getPassword());
    //     UserDetails admin = User.withUsername("admin")
    //             .password(passwordEncoder().encode("adminPass"))
    //             .roles("ADMIN")
    //             .build();
    //     return new InMemoryUserDetailsManager(user1, user2, admin);
    //     // InMemoryUserDetailsManager (see below)
    // }


    // Para desligar o CORS
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     // builder de configurações http para autorizar requisições e formulário de
    //     // login.
    //     // Vamos autorizar um anônimo acessar "/login"

    //     // A ordem das regras é importante!
    //     // Primeiro os mais especificos, seguidos dos mais gerais
    //     // http.cors().configurationSource(corsConfigurationSource())
    //     //     .and()
    //     //     .csrf() // Configurações para evitar ataques csrf()
    //     //     .disable()

    //     //     // Evita erro de CORS
    //     //     // .cors()
    //     //     // .and()
    //     //     .authorizeRequests()

    //     //     // .antMatchers(HttpMethod.OPTIONS, "/**")
    //     //     // .permitAll()

    //     //     // .antMatchers("/admin/**")
    //     //     // .hasRole("ADMIN")

    //     //     // .antMatchers("/anonymous*")
    //     //     // .anonymous()

    //     //     .antMatchers("/userauth")
    //     //     .permitAll()

    //     //     .anyRequest()
    //     //     .authenticated()
    //     //     .and()

    //     //     // Configurando o Form Login
    //     //     // .formLogin()
    //     //     // .loginProcessingUrl("/userAuth")

    //     //     // .and()
            
    //     //     .logout()
    //     //     .logoutUrl("/logout")

    //     //     .and()
    //     //     .httpBasic();
    //     http.cors().configurationSource(corsConfigurationSource())
    //         .and()
    //         .csrf()
    //         .disable()
    //         .authorizeRequests()
    //         .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
    //         .antMatchers(HttpMethod.POST, "/user").permitAll()
    //         .antMatchers(HttpMethod.POST, "/login").permitAll()
    //         // .antMatchers("/userauth/**").permitAll()
    //         .anyRequest().authenticated();
    //         // .and()
    //         // .httpBasic();

    //     // // Define o proveddor de autenticação
    //     // http.authenticationProvider(authenticationFilter);

    //     // Filtro que gera o Token JWT
    //     // http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    //     // Configura um filtro que executa uma vez antes de outro filtro
    //     // http
    //     //     .addFilterBefore(new AuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
    //     // Direção: Client -> Server. Executado quando um Client vai fazer login na nossa aplicação.
    //     // Ex: Post /login/auth -> Esse filtro então irá receber o ususario e senha e verificar se ele pode acessar a aplicação
    //     //     Em caso positivo, será gerado um Token Jwt e enviado para o client.
    //     // AuthenticationManager manager = http.getSharedObject(AuthenticationManager.class);
        
    //     // if(manager == null){
    //     //     System.err.println("É nulo sim!");
    //     // }
        
    //     // jwtLoginFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

    //     http.addFilterBefore(
    //         // new JwtLoginFilter("/login", authenticationManager(new AuthenticationConfiguration())), 
    //         new JwtLoginFilter("/login", authenticationManager()), 
    //         UsernamePasswordAuthenticationFilter.class);

    //     return http.build();
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(corsConfigurationSource())
                .and().csrf().disable().authorizeRequests()
                // .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/usuario").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.POST, "/areaConhecimento").permitAll()
                .antMatchers(HttpMethod.POST, "/questao").permitAll()
                .antMatchers(HttpMethod.POST, "/alternativas").permitAll()
                .anyRequest().authenticated()
                .and()
                // We filter the api/login requests
                .addFilterBefore(new JwtLoginFilter("/login", jwtUtils, authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(authenticationJwtFilter,
                        UsernamePasswordAuthenticationFilter.class);
    }

    // @Bean
    // AbstractAuthenticationProcessingFilter jwtFilter(HttpSecurity http){
    //     return new JwtLoginFilter("/login", http.getSharedObject(AuthenticationManager.class));
    // }
}
