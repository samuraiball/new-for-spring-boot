package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity
//WebSecurityConfigurerAdapterをつかうことで継承することで、設定したいところだけを設定できる。
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //configure(WebSecurity web)で特定のリクエストに対してセキュリティを無視する設定などができる。
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**","/css/**");
    }

    //configure(HttpSecurity http)は認可に関する設定ができる
    @Override
    protected void  configure(HttpSecurity http)throws Exception {
        http.authorizeRequests()
                //すべてのユーザがログインフォームにアクセスできるように設定
                .antMatchers("/loginForm").permitAll()
                //上記以外のリクエストを認証なしではアクセス出来ないようにする。
                .anyRequest().authenticated()
                .and()
                //ログインに関する設定を行う。
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/loginForm")
                .defaultSuccessUrl("/customers",true)
                .failureUrl("/loginForm?error")
                //ユーザ名とパスワードの設定
                .usernameParameter("username").passwordParameter("password")
                .and()
                //ログアウトの設定
                //デフォルトでは'/logout'に対してPOSTでアクセスするとログアウトできるようになる。
                .logout()
                .logoutSuccessUrl("/loginForm");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }
}
