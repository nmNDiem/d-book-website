export const CartReducer = (quantityInCart, action) => {
    switch (action.type) {
        case 'updateCart':
            return action.payload;
        default:
            return quantityInCart;
    }
}
