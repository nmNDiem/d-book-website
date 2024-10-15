import React from 'react';
import { Create, ImageField, ImageInput, SimpleForm } from 'react-admin';

const BannerCreate = (props) => (
    <Create {...props}>
        <SimpleForm>
            <ImageInput source="image" label="Image" accept="image/*" placeholder={<p>Tải hình ảnh</p>}>
                <ImageField source="src" title="title" />
            </ImageInput>
        </SimpleForm>
    </Create>
);

export default BannerCreate;