# Simple Web Server (Java)

Bu proje, Java kullanılarak oluşturulmuş temel bir web sunucusudur. Sunucu, belirtilen port üzerinden HTTP isteklerini dinler ve basit bir HTML sayfası döner. Bu uygulama, socket programlama, HTTP protokolü ve sunucu-istemci iletişimi konularını öğrenmek isteyenler için mükemmel bir örnektir.

## Özellikler

-   Tamamen **Java Standard Library** kullanır (ek kütüphane gerektirmez).
-   Tarayıcıdan erişilebilen basit bir HTML sayfası sunar.
-   Her yeni istemci bağlantısını terminalde görüntüler.
-   **UTF-8** desteği ile Türkçe karakterleri doğru şekilde gösterir.
-   HTML yapısı ve CSS tasarımı tamamen dinamik olarak Java üzerinden oluşturulur.

## Kullanılan Teknolojiler

| Teknoloji | Amaç |
|---|---|
| **Java (JDK 17+)** | Ana programlama dili |
| `ServerSocket` | Sunucu soketini oluşturmak için |
| `Socket` | İstemci bağlantılarını yönetmek için |
| `PrintWriter` | HTTP yanıtlarını istemciye göndermek için |
| **UTF-8 Encoding** | Türkçe karakter desteği için |

## Nasıl Çalışır?

1.  Sunucu belirtilen portta (`1989`) dinlemeye başlar.
2.  Bir istemci (örneğin web tarayıcısı) [http://localhost:1989](http://localhost:1989) adresine istek gönderir.
3.  Sunucu, HTML içerikli bir `HTTP 200 OK` yanıtı döner.
4.  Tarayıcı bu içeriği bir web sayfası olarak görüntüler.

## Kurulum ve Çalıştırma

### 1. Derleme
Kodu derlemek için terminalde aşağıdaki komutu çalıştırın:
```bash
javac SimpleWebServer.java
```

### 2. Çalıştırma
Sunucuyu başlatmak için aşağıdaki komutu kullanın:
```bash
java SimpleWebServer
```

### 3. Tarayıcıdan Erişim
Aşağıdaki adresi tarayıcınıza girin:
[http://localhost:1989](http://localhost:1989)

## Öğrenme Noktaları

Bu proje sayesinde aşağıdaki konularda pratik kazanabilirsiniz:
-   **TCP/IP** tabanlı sunucu-istemci iletişimi
-   HTTP protokolünün temel yapısı (**header, body, status code**)
-   Java **I/O** (Input-Output) işlemleri
-   Dinamik **HTML** üretimi
-   Sunucu tarafında kaynak yönetimi (**try-with-resources**)

## Örnek Terminal Çıktısı
```plaintext
Sunucu 1989 portunda başlatıldı.
Tarayıcınızdan http://localhost:1989 adresine giderek test edebilirsiniz.
Yeni bir istemci bağlandı: 127.0.0.1
```

## Proje Hakkında

-   Bu proje **Burhan Koçak** tarafından, Java Socket Programlama ve HTTP sunucu mimarisi konularını anlamak amacıyla geliştirilmiştir.
-   HTML sayfasında yer alan bilgiler, geliştiriciye ait kişisel profil örneğidir.

## Lisans

Bu proje eğitim amaçlı hazırlanmıştır. İsteyen herkes özgürce inceleyebilir, değiştirebilir veya geliştirebilir.
