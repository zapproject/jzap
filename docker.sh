
sudo docker pull jzapdocker/hardhat:v1
sudo docker run -d jzapdocker/hardhat:v1 | cut -b 1-12 > containerID.txt
sleep 60