# Upgrade

## 서비스 중지

    sudo systemctl stop sleek
    sudo systemctl stop willy
    sudo systemctl stop dmlab

혹시 systemd 설정 변경했으면

    sudo systemctl daemon-reload
    
## 디비 백업

    mysqldump -u drypot -p sleek > backup_xxx.sql

## Arch Linux 업데이트

    sudo pacman -S archlinux-keyring
    sudo pacman -Syu

## 전역 툴 업데이트

    sudo npm install -g mocha

## 코드 업데이트

    git pull
    npm install

## 설정 업데이트

    config/...

## 재부팅

    reboot

## 서비스 오류 확인

    sudo systemctl --failed

Arch 서비스 Fail 나면

    pacman -Rs ... 로 패키지 삭제했다가
    pacman -S ... 로 재설치 시도.

## 테스트 런

    $ bin/run-???
    
이상 없으면

    sudo systemctl restart sleek
    sudo systemctl restart willy
    sudo systemctl restart dmlab
