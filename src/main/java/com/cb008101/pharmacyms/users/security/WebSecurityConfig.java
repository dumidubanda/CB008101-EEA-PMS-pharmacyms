package com.cb008101.pharmacyms.users.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.authorizeRequests()
//                .anyRequest() .permitAll() ;      //super.configure(http);
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/").permitAll();
//
//    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable();
        http.authorizeRequests()
//                .antMatchers("/").permitAll();
//                .antMatchers("/users/**").hasAuthority("Admin")
//                .antMatchers(
//                        "/viewBrands",
//                        "/showAddBrandForm",
//                        "/addNewBrand",
//                        "/showUpdateBrandForm/**",
//                        "/deleteBrand/**",
//                        "/showAddCategoryForm",
//                        "/addNewCategory",
//                        "/showUpdateCategoryForm/**",
//                        "/updateCategory/**",
//                        "/deleteCategory/**",
//                        "/viewCustomers",
//                        "/showAddPharmaItemForm",
//                        "/addNewPharmaItem",
//                        "/showUpdatePharmaItemForm/**",
//                        "/updatePharmaItem/**",
//                        "/deletePharmaItem/**",
//                        "/viewItemStocks",
//                        "/showAddStockForm",
//                        "/addNewStock",
//                        "/showUpdateStockForm/**",
//                        "/updateStock/**",
//                        "/deleteStock/**"
//                    ).hasAuthority("Pharmacists")


//                .antMatchers(
//                        "/viewBrands",
//                        "/showAddBrandForm",
//                        "/addNewBrand",
//                        "/showUpdateBrandForm/**",
//                        "/deleteBrand/**",
//                        "/viewCategories",
//                        "/showAddCategoryForm",
//                        "/addNewCategory",
//                        "/showUpdateCategoryForm/**",
//                        "/updateCategory/**",
//                        "/deleteCategory/**",
//                        "/viewCustomers",
//                        "/viewPharmaItem",
//                        "/viewItemStocks"
//                ).hasAuthority("Sales Manager")
//
//                .antMatchers(
//                        "/viewBrands",
//                        "/viewCategories",
//                        "/viewCustomers",
//                        "/viewPharmaItem",
//                        "/viewItemStocks"
//                ).hasAuthority("Web Site Editor")

//                .antMatchers(
//                        "/viewBrands",
//                        "/viewCategories",
//                        "/viewCustomers",
//                        "/viewPharmaItem",
//                        "/viewItemStocks"
//                ).hasAuthority("Shipper")

//                .antMatchers(
//                        "/viewBrands",
//                        "/showAddBrandForm",
//                        "/addNewBrand",
//                        "/showUpdateBrandForm/**",
//                        "/deleteBrand/**",
//                        "/showAddCategoryForm",
//                        "/addNewCategory",
//                        "/showUpdateCategoryForm/**",
//                        "/updateCategory/**",
//                        "/deleteCategory/**",
//                        "/viewCustomers",
//                        "/showAddPharmaItemForm",
//                        "/addNewPharmaItem",
//                        "/showUpdatePharmaItemForm/**",
//                        "/updatePharmaItem/**",
//                        "/deletePharmaItem/**",
//                        "/viewItemStocks",
//                        "/showAddStockForm",
//                        "/addNewStock",
//                        "/showUpdateStockForm/**",
//                        "/updateStock/**",
//                        "/deleteStock/**"
//                ).hasAuthority("Pharmacists")


                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");

    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers
                ("/images/**",
                        "/js/**",
                        "/webjars/**",
                        "/css/**",
                        "/media/**",
                        "/bootstrap-5.1.3-dist/**",
                        "/fontawesome/**",
                        "/webfonts/**"
                );
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        return new PmsUserDetailsService();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(authenticationProvider());
    }
}

