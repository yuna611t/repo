FROM ubuntu:16.04
MAINTAINER Yuta Naganuma <yuna611t@gmail.com>

RUN apt-get update -y
RUN apt-get install build-essential -y
RUN apt-get update -y

# install jdk
RUN apt-get install openjdk-8-jdk -y

# install maven
RUN apt-get install maven -y
# install gradle
RUN apt-get install gradle -y



# adduser
RUN adduser --disabled-password --gecos "" tester

# add sample files
USER tester
RUN cd ~ && mkdir sample share
COPY sample /home/tester/sample/

## docker run -it java-test:x.x
#
CMD ["/bin/bash"]

# run following command
# docker run -u tester -v /Users/yuna/dev/docker/ci/share:/home/tester/share -i -t java-test:0.8  /bin/bash
