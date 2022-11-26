# fitness-web-site
Fitness-Web-Site
Projenin amacı
Fitness salonuna sahip olan müşterinin salonunda verdiği eğitimleri o eğitimlerin hocalarını, üyelerin bilgi kayıtlarını ve aldığı eğitimleri ayrıyetten başlangıç ve bitiş tarihini tutabildiği, her hocanında verdiği eğitime göre diyet ve program listesi hazırlayabileceği bir web projesidir. Projenin sağladığı kolaylıklardan bir tanesi ise üyelerin internetin olduğu her yerde yazılmış olan program ve diyet listesine erişebilmesi. Spor yapmak için salona gittiği zaman yapabileceği programları elinde gereksiz kağıt taşımak yerine telefonundan bakıp halledebileceği bir web projesidir. Ve üyelerimiz kendi boy ve kilo bilgisine göre vücut kitle indeksini hesaplayabilecektir.

Projeyi Nasıl Çalıştırabilirim ?
1-) Netbeans 8.2, jdk 1.8.0_251 ve Java-EE kurulumu.

2-) Glassfish 5.1.0 kurulumu.

3-) HeidiSQL 10.4 kurulumu. (MariaDB or MySQL)

4-) Kurulumlar sağlandıktan sonra proje içerisinde bulunan salon.sql dosyasını HeidiSQL üzerinde açıp kaydediniz.

5-) Projeyi Run etmek için gerekli ayarlar yapıldıktan sonra projeyi Netbeans IDE'si üzerinde bulunan tarayıcı seçeneklerini GoogleChrome seçtikten sonra Run edebilirsiniz.

Giriş İçin
Admin girişi için ->

Kullanıcı Mail: admin
Şifre: admin giriniz.

Üye girişi için proje içine atılmış olan salon.sql dosyasını hediSQL üzerinde çalıştırıp salon veritabanını açıp üyeler kısmında admin kısmı değeri "0" olan herhangi bir üyeyle giriş yapabilirsiniz.

Validatör
Proje için istenilen validatörler bean ve html tarafı olmak üzere iki farklı şekilde yapılmıştır.

HTML validatörünü back_end dosyasında olcum formunda bulabilirsiniz.

Bean validatörleri ise back_end dosyasında Üye, Eğitim ve Eğitmen formlarda kullanılmıştır.

Converter
Projede 4 adet converter uygulanmıştır.Bunlardan 3 tanesi one to many ilişkisi için 1 tanesi ise many to many ilişkisi için kullanılmıştır.

Many to many ilişkisi üyeler ve eğitimler arasında alınan eğitim olarak uygulanmıştır.

HTML tarafında bilgi işlemde alınan eğitim sütunlarında bu ilişkiyi görebilirsiniz.

Dosya İşlemleri
dosyaController sınıfı içinde yazılmış olan "uploadTo" dosya yolunu içinde bulunan upload klasörünün dosya yolu ile değişiniz.

Şifremi Unuttum
Şifremi unuttum kısmında çalışması için yazılan kodlar uyedao sınıfında bulunmaktadır.

Kayıt ol
Kayıt ol kısmında çalışması için yazılan kodlar uyedao sınıfında bulunmaktadır.
