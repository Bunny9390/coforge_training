function Product(props) {
  return (
    <div>
      <h2>Product Details</h2>

      <p>Product : {props.name}</p>
      <p>Price : {props.price}</p>
      <p>Brand : {props.brand}</p>
      <p>Rating : {props.rating}</p>
      <p>Stock : {props.stock}</p>
    </div>
  );
}

export default Product;