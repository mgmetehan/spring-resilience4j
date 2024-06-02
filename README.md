# spring-resilience4j

## Resilience4j Retry Ozelligi:

Resilience4j kutuphanesi, hata durumlarinda otomatik olarak tekrar deneme yapmayi saglayan Retry ozelligini saglar. Bu ozellik, belirli hatalarin veya kosullarin meydana gelmesi durumunda bir islemi tekrar denemek icin yapilandirilabilir.

### 1. `getRetry` Retry Ornegi:

```yaml
resilience4j:
  retry:
    instances:
      getRetry:
        maxAttempts: 4 # Maksimum deneme sayisi
        waitDuration: 2000ms # Denemeler arasindaki bekleme suresi
        failAfterMaxAttempts: true # Maksimum deneme sayisina ulasildiginda islem basarisiz olacak mi?
        enable-exponential-backoff: true # Ustel geriye sayimi etkinlestir
        exponential-backoff-multiplier: 2 # Ustel geriye sayim carpani
```

- `maxAttempts`: Maksimum deneme sayisi, ornegin burada islem en fazla 4 kez tekrar denenecek.
- `waitDuration`: Denemeler arasindaki sabit bekleme suresi, burada her deneme arasinda 2000 milisaniye (2 saniye) beklenir.
- `failAfterMaxAttempts`: Maksimum deneme sayisina ulasildiginda islem basarisiz olacak mi?
- `enable-exponential-backoff`: Ustel geriye sayimi etkinlestir, yani her tekrarda bekleme suresini artir.
- `exponential-backoff-multiplier`: Ustel geriye sayim carpani, yani her tekrarda bekleme suresini artirmak icin kullanilan faktor.

### 2. `customRetry` Retry Ornegi:

```yaml
resilience4j:
  retry:
    instances:
      customRetry:
        maxAttempts: 5
        waitDuration: 2s
        failAfterMaxAttempts: true
        enable-exponential-backoff: true
        exponential-backoff-multiplier: 2
        retry-exceptions:
          - java.io.IOException
        ignore-exceptions:
          - java.lang.NullPointerException
```

- `retry-exceptions`: Tekrar denemesine neden olacak ozel istisna siniflarinin listesi, burada sadece `IOException` nedeniyle tekrar deneme yapilacak.
- `ignore-exceptions`: Tekrar denemesi yapilmamasi gereken istisna siniflarinin listesi, burada `NullPointerException` nedeniyle tekrar deneme yapilmayacak.
