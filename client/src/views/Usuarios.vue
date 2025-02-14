<template>
    <div>
        <h1>Lista de Usuários</h1>
        <button @click="carregarUsuarios">Carregar Usuários</button>
        <ul>
            <li v-for="usuario in usuarios" :key="usuario.id">
                {{ usuario.nome }} - {{ usuario.email }}
            </li>
        </ul>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
    computed: {
        ...mapState(['usuarios']),
    },
    methods: {
        ...mapActions(['fetchUsuarios']),
        carregarUsuarios() {
            this.fetchUsuarios();
        }
    }
};
</script>
