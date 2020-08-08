## pengeluaranku

Salam

Ini adalah aplikasi yang saya gunakan untuk mencatat pengeluaran harian

Silahkan bila teman-teman ada yang membutuhkan
Terbuka untuk saran dan masukan juga

### Installation

- Install java 1.8 atau lebih
- Install ekstensi lombok pada IDE anda
- Install maven
- Buat database dan user baru sesuai application.yaml
- install keycloak 10.0.2
- Buat akun admin keycloak, sesuaikan credentialnya di application.yaml


```sh
$ cd pengeluaranku
$ mvn clean install -DskipTests=true
$ mvn spring-boot:run
```

# Terimakasih