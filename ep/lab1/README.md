# Kwestia życia i śmierci

Model misji z Wiedźmina 3 jako proces biznesowy, przygotowany na podstawie
[opisu w polskiej wiki](https://wiedzmin.fandom.com/wiki/Kwestia_%C5%BCycia_i_%C5%9Bmierci),
[wersji angielskiej](https://witcher.fandom.com/wiki/A_Matter_of_Life_and_Death_(The_Witcher_3)),
i wideo z gry (część [1](https://www.youtube.com/watch?v=WdXvHx-pSvQ),
[2](https://www.youtube.com/watch?v=Ge1M9BETU_g), [3](https://www.youtube.com/watch?v=00xeUDNzQEE)
i [4](https://www.youtube.com/watch?v=aaP2H6hNnYA)).

## Uruchomienie

Do działającej instancji Process Makera można zaimportować plik [Kwestia_życia_i_śmierci.pmx](Kwestia_życia_i_śmierci.pmx),
ale pewniejszym rozwiązaniem jest uruchomienie aplikacji w Dockerze z przygotowanymi woluminami,
bo zachowuje wszystkie dane zapisane w systemie, w tym użytkowników.

```sh
git clone https://github.com/hejmsdz/iti2
cd iti2/ep/lab1
tar xzf volumes.tar.gz
docker-compose up
open http://localhost:8080
# ^ otwórz w ulubionej przeglądarce, gdy Docker wstanie
```

.## Logowanie do systemu

* Workspace: `ep`
* Konto administratora: `admin`:`admin`
* Konta użytkowników:
  - `geralt`:`abc123` (Geralt z Rivii)
  - `triss`:`abc123` (Triss Merigold)
  - `sluga`:`abc123` (sługa Vegelbudów)

