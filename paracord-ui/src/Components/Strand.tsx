import React from 'react'

interface Props {
  name: string
}

const Strand: React.FunctionComponent<Props> = (props: Props) => {
  return (
    <div className="w-1/3 p-2">
      <div className="max-w-sm rounded overflow-hidden shadow-lg bg-red-400">
        <div className="px-6 py-4">
          <div className="font-bold text-xl mb-2 text-center">{props.name}</div>
        </div>
      </div>
    </div>
  )
}

export default Strand
