<template>
    <div>
        <h1>Bem-vindo ao Sistema de Usuários!</h1>
        <p>Esta é a página inicial. Você pode acessar a lista de usuários abaixo:</p>
        <button @click="navegarParaUsuarios">Ir para a lista de Usuários</button>
    </div>
</template>

<script>
export default {
    methods: {
        navegarParaUsuarios() {
            // Navega para a página de usuários
            this.$router.push('/usuarios');
        }
    }
};
</script>

<style scoped>
h1 {
    color: #42b983;
}

button {
    padding: 10px 20px;
    background-color: #42b983;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #338e6f;
}
</style>
