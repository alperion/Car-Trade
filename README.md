## Araç kiralama servisi senaryosu kullanılmıştır  . Uygulamada PostgreSql veri tabanı kullanılmıştır .

## users-controller
### /users/register  : Kullanıcılar kayıt olabilir
### /users/login : Kullanıcılar email ve şifre girerek giriş yapabilir
### /users/addMoney : Kullanıcı token ve para miktarı girerek hesabına para yükleyebilir
### /users/getCompanies/{token} : Kullanıcı token verisi ile şirketleri görüntüleyebilir.
### /users/getCompanies/{token}/{companyId} : Kullanıcı token ve şirket id'si ile araçları görüntüleyebilir

## company-controller
### /company/addCompany : Kullanıcı token ve şirket ismi verileri ile kendi şirketini oluşturabilir
### /company/updateCompany : Kullanıcı şirket id'si ,token ve şirket ismi verileri ile şirketin ismini güncelleyebilir.
### /company/deleteCompany : Kullanıcı şirket id'si ve token ile şirketini silebilir .

## car-controller
### /car/updateCar : Kullanıcı token ,araba id'si ,yeni araba ismi ve araba fiyatı yazılarak id'si verilen araç güncellenebilir.
### /car/addCar : Kullanıcı token ,şirket id'si , araba ismi ve araba fiyatı veileri yazılarak şirkete yeni bir araba eklenebilir.
### /car/deleteCar : Kullanıcı token ve araba id'si verilerini yazarak şirkete ait bir araç silinebilir

## hired-car-controller
### /hiredcar/hireNewCar : Kullanıcı token , araç id'si ve kiralanmak istenen gün sayısı yazılarak araç kiralanabilir
