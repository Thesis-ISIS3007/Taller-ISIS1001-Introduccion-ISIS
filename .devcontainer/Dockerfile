# syntax=docker/dockerfile:1

FROM mcr.microsoft.com/devcontainers/base:noble

ENV DEBIAN_FRONTEND=noninteractive
ENV LANG=C.UTF-8

RUN apt update && \
apt install -y --no-install-recommends \
ca-certificates \
curl \
wget \
make \
verilator && \
rm -rf /var/lib/apt/lists/*