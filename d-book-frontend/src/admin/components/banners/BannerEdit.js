import React from 'react';
import { Edit, ImageField, ImageInput, SimpleForm } from 'react-admin';

const BannerEdit = (props) => (
    <Edit {...props}>
        <SimpleForm>
            <ImageInput source="image" label="Image" accept="image/*" placeholder={<p>Tải hình ảnh</p>}>
                <ImageField source="src" title="title" />
            </ImageInput>
        </SimpleForm>
    </Edit>
);

export default BannerEdit;