/*
 variável que pega valor da variável de ambiente. caso não haja, pega valor do localhost
 */

export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";