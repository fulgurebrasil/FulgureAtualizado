<template>
    <div>
        <b-button v-b-modal.modal-2 class="pular"><img src="~/static/coracaoPartido.png" width="20px"
                height="20px" /><span>Pular</span>
        </b-button>
        <b-modal id="modal-2" title="Você tem certeza?" cancel-variant="danger">
            <p class="my-4">Ao pular a questão, você perderá 01 vida. Caso esteja ciente e queira prosseguir, clique em OK.</p>
        </b-modal>
    </div>
</template>

<script>
export default {

}
</script>

<style>
img {
    margin-right: 5px;
}

.pular {
    background-color: rgb(251, 192, 30);
    border-color: transparent;
    font-weight: bold;
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.pular:hover {
    background-color: rgb(206, 152, 3);
    border-color: transparent;
}

@media only screen and (max-device-width: 400px) {
    .pular span {
        display: none;
    }

    .pular {
        width: 48px;
    }
}
</style>