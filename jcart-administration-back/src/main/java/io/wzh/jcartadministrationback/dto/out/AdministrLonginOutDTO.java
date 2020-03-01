package io.wzh.jcartadministrationback.dto.out;

public class AdministrLonginOutDTO {

    private String token;
    private Long expiretimestamp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpiretimestamp() {
        return expiretimestamp;
    }

    public void setExpiretimestamp(Long expiretimestamp) {
        this.expiretimestamp = expiretimestamp;
    }
}
