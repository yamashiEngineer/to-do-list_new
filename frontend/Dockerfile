# Node.jsの公式イメージをベースにする（これでnpmが使えるようになります）
FROM node:20-alpine

WORKDIR /app

# パッケージ管理ファイルをコピーして依存関係をインストール
COPY package*.json ./
RUN npm install

# 残りのソースコードをコピー
COPY . .

# Reactの開発サーバーを起動（Viteなどの場合は 5173 ポートなど）
EXPOSE 5173
CMD ["npm", "run", "dev"]